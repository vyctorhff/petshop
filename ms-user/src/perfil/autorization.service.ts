import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { UserAutorizationDto } from './dtos/user-autorization.dto';
import { Perfil } from './entities/perfil.entity';

@Injectable()
export class AutorizationService {

  constructor(
    @InjectRepository(Perfil)
    private readonly repository: Repository<Perfil>,
  ) {}

  async isUserAdmin(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, 'admin');
  }

  async isUserEmployee(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, 'employee');
  }

  async isUserBasic(user: UserAutorizationDto): Promise<boolean> {
    return this.checkPermission(user, 'basic');
  }

  async checkPermission(user: UserAutorizationDto, perfilName: string): Promise<boolean> {
    const result = await this.repository.find({
      relations: {
        users: true,
      },
      where: {
        name: perfilName,
        users: {
          id: user.id,
        },
      },
    });

    return !result && result.length > 0;
  }
}
