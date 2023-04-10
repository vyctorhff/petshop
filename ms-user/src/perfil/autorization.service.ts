import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';

import { UserAutorization } from './dtos/user-autorization.dto';
import { Perfil } from './entities/perfil.entity';
import { Repository } from 'typeorm';

@Injectable()
export class AutorizationService {
  constructor(
    @InjectRepository(Perfil)
    private readonly repository: Repository<Perfil>,
  ) {}

  async isUserAdmin(user: UserAutorization): Promise<boolean> {
    return Promise.resolve(false);
  }

  async isUserEmployee(user: UserAutorization): Promise<boolean> {
    return Promise.resolve(false);
  }

  async isUserBasic(user: UserAutorization): Promise<boolean> {
    return Promise.resolve(false);
  }
}
