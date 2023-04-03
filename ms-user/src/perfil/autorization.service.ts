import { Injectable } from '@nestjs/common';
import { PerfilRepository } from './perfil.repository';

@Injectable()
export class AutorizationService {
  constructor(private readonly repository: PerfilRepository) {}

  isUserAdmin(): boolean {
    return this.repository.isUserAdmin();
  }

  isUserEmployee(): boolean {
    return this.repository.isUserEmployee();
  }

  isUserBasic(): boolean {
    return this.repository.isUserBasic();
  }
}
