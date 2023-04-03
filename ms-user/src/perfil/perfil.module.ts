import { Module } from '@nestjs/common';

import { PerfilService } from './perfil.service';
import { PerfilController } from './perfil.controller';
import { PerfilRepository } from './perfil.repository';
import { AutorizationService } from './autorization.service';

@Module({
  controllers: [PerfilController],
  providers: [PerfilRepository, PerfilService, AutorizationService],
})
export class PerfilModule {}
