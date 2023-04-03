import { Injectable } from '@nestjs/common';

import { Perfil } from './domains/perfil.domain';
import { UserAutorization } from './dtos/user-autorization.dto';

@Injectable()
export class PerfilRepository {

  findAll(): Perfil[] {
    return [
      { id: 1, name: 'admin' },
      { id: 1, name: 'employee' },
      { id: 1, name: 'user' },
    ];
  }

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
