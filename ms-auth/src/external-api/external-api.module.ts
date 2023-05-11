import { Module } from '@nestjs/common';
import { ExternalApiService } from './external-api.service';
import { UserExternalService } from './user-external.service';

@Module({
  providers: [ExternalApiService, UserExternalService],
  exports: [ExternalApiService, UserExternalService],
})
export class ExternalApiModule {}
