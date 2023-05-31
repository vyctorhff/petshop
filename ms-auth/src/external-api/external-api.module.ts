import { Module } from '@nestjs/common';
import { ExternalApiService } from './external-api.service';
import { UserExternalService } from './user-external.service';
import { ConfigModule } from '@nestjs/config';
import { HttpModule } from '@nestjs/axios';

@Module({
  imports: [ConfigModule, HttpModule],
  providers: [ExternalApiService, UserExternalService],
  exports: [ExternalApiService, UserExternalService],
})
export class ExternalApiModule {}
