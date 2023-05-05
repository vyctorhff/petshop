import { Module } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';

import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AuthorizationModule } from './authorization/authorization.module';
import { jwsConstant } from './authorization/constants';

@Module({
  imports: [
    AuthorizationModule,
    JwtModule.register({
      global: true,
      secret: jwsConstant.secret,
      signOptions: { expiresIn: '180s' },
    }),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
