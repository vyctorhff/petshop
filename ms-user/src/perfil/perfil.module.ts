import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { PerfilService } from './perfil.service';
import { PerfilController } from './perfil.controller';
import { AutorizationService } from './autorization.service';
import { Perfil } from './entities/perfil.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Perfil])],
  controllers: [PerfilController],
  providers: [PerfilService, AutorizationService],
})
export class PerfilModule {}
