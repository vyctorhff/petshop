import { Injectable, Logger } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { Perfil } from './entities/perfil.entity';
import { FindDTO } from './dtos/find.dto';

@Injectable()
export class PerfilService {
  private readonly logger = new Logger('[PerfilService]');

  constructor(
    @InjectRepository(Perfil)
    private readonly repository: Repository<Perfil>,
  ) {}

  async findAll(findDto: FindDTO): Promise<Perfil[]> {
    const builder = this.repository.createQueryBuilder('perfil');

    if (findDto.hasId()) {
      builder.andWhere('perfil.id = :id', { id: findDto.id });
    }

    if (findDto.hasName()) {
      builder.andWhere('perfil.name = :name', { name: findDto.name });
    }

    return builder.getMany();
  }
}
