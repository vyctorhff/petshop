import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { UserAutorizationDto } from './dtos/user-autorization.dto';
import { Perfil } from './entities/perfil.entity';

export enum PerfilType {
  ADMIN = 'admin',
  EMPLOYEE = 'employee',
  BASIC = 'basic',
}

@Injectable()
export class AutorizationService {
  constructor(
    @InjectRepository(Perfil)
    private readonly repository: Repository<Perfil>,
  ) {}

  async isUserAdmin(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, PerfilType.ADMIN);
  }

  async isUserEmployee(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, PerfilType.EMPLOYEE);
  }

  async isUserBasic(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, PerfilType.BASIC);
  }

  async checkPermission(
    user: UserAutorizationDto,
    perfil: PerfilType,
  ): Promise<boolean> {
    const result = await this.repository
      .createQueryBuilder('perfil')
      .innerJoinAndSelect('perfil.users', 'user')
      .where('user.id = :id AND perfil.name = :name', {
        id: user.id,
        name: perfil.toString(),
      })
      .getMany();

    return Array.isArray(result) && result.length > 0;
  }
}
