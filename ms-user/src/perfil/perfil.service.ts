import { Injectable } from '@nestjs/common';

import { Perfil } from './entities/perfil.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

@Injectable()
export class PerfilService {
  constructor(
    @InjectRepository(Perfil)
    private readonly repository: Repository<Perfil>,
  ) {}

  async findAll(): Promise<Perfil[]> {
    return await this.repository.find({});
  }
}
