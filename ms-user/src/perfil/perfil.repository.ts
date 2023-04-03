import { Injectable } from '@nestjs/common';
import { Perfil } from './domains/perfil.domain';

@Injectable()
export class PerfilRepository {
  findAll(): Perfil[] {
    return [
        {id: 1, name: 'admin' },
        {id: 1, name: 'employee' },
        {id: 1, name: 'user' }
    ];
  }

  isUserAdmin(): boolean {
    return false;
  }

  isUserEmployee(): boolean {
    return false;
  }

  isUserBasic(): boolean {
    return false;
  }
}
