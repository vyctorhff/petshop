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

  isUserAdmin(user: UserAutorization): boolean {
    return false;
  }

  isUserEmployee(user: UserAutorization): boolean {
    return false;
  }

  isUserBasic(user: UserAutorization): boolean {
    return false;
  }
}
