import { Module } from '@nestjs/common';
import { PerfilService } from './perfil.service';
import { PerfilController } from './perfil.controller';
import { PerfilRepository } from './perfil.repository';

@Module({
  controllers: [PerfilController],
  providers: [
    PerfilRepository,
    PerfilService,
  ],
})
export class PerfilModule {}
