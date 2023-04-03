import { Injectable } from '@nestjs/common';
import { PerfilRepository } from './perfil.repository';
import { Perfil } from './domains/perfil.domain';

@Injectable()
export class PerfilService {
  constructor(private readonly repositoy: PerfilRepository) {}

  findAll(): Perfil[] {
    return this.repositoy.findAll();
  }

  isUserAdmin(): boolean {
    return this.repositoy.isUserAdmin();
  }

  isUserEmployee(): boolean {
    return this.repositoy.isUserEmployee();
  }

  isUserBasic(): boolean {
    return this.repositoy.isUserBasic();
  }
}
