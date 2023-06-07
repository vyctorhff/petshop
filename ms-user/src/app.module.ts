import { Module } from '@nestjs/common';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';

import { dataOptions } from './infra/typeorm-config';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { PerfilModule } from './perfil/perfil.module';
import { UserModule } from './user/user.module';

@Module({
  imports: [
    ConfigModule.forRoot(),
    // TypeOrmModule.forRootAsync(dataOptions),
    TypeOrmModule.forRoot(dataOptions),
    PerfilModule,
    UserModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
