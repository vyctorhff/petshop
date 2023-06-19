import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm/dist';

import { AuthorizationController } from './authorization.controller';
import { AuthorizationService } from './authorization.service';
import { ExternalApiModule } from 'src/external-api/external-api.module';
import { CreateAuthorizationService } from './create-authorization.service';
import { Authentication } from './entities/authorization.entity';

@Module({
  imports: [
    TypeOrmModule.forFeature([Authentication]),
    ExternalApiModule,
  ],
  controllers: [AuthorizationController],
  providers: [
    AuthorizationService,
    CreateAuthorizationService,
  ],
})
export class AuthorizationModule {}
