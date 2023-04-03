import { Injectable } from '@nestjs/common';

import { PerfilRepository } from './perfil.repository';
import { UserAutorization } from './dtos/user-autorization.dto';

@Injectable()
export class AutorizationService {
  constructor(private readonly repository: PerfilRepository) {}

  isUserAdmin(user: UserAutorization): boolean {
    return this.repository.isUserAdmin(user);
  }

  isUserEmployee(user: UserAutorization): boolean {
    return this.repository.isUserEmployee(user);
  }

  isUserBasic(user: UserAutorization): boolean {
    return this.repository.isUserBasic(user);
  }
}
