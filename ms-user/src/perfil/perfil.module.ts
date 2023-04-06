import { Module } from '@nestjs/common';

import { PerfilService } from './perfil.service';
import { PerfilController } from './perfil.controller';
import { AutorizationService } from './autorization.service';

@Module({
  controllers: [PerfilController],
  providers: [PerfilService, AutorizationService],
})
export class PerfilModule {}
