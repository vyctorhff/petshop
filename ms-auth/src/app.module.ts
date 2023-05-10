import { Module } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { ConfigModule } from '@nestjs/config';

import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AuthorizationModule } from './authorization/authorization.module';
import { ExternalApiModule } from './external-api/external-api.module';

@Module({
  imports: [
    ConfigModule.forRoot(),
    AuthorizationModule,
    JwtModule.register({
      global: true,
      secret: process.env.JWS_SECRET,
      signOptions: { expiresIn: '180s' },
    }),
    ExternalApiModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
