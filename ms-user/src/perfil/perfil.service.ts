import { Injectable } from '@nestjs/common';
import { PerfilRepository } from './perfil.repository';
import { Perfil } from './domains/perfil.domain';

@Injectable()
export class PerfilService {
  constructor(private readonly repository: PerfilRepository) {}

  findAll(): Perfil[] {
    return this.repository.findAll();
  }
}
