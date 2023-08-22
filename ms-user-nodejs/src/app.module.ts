import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { AppController } from './app.controller';
import { AppService } from './app.service';
import { UserModule } from './user/user.module';
import { PerfilModule } from './perfil/perfil.module';
import { ConfigModule } from '@nestjs/config';

@Module({
  imports: [
    ConfigModule.forRoot(),
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: 'localhost',
      port: 5432,
      username: 'dev',
      password: '123',
      database: 'petshot-ms-user',
      entities: [`${__dirname}/**/*.entity{.js,.ts}`],
      migrations: [`${__dirname}/migrations/*-*{.ts,*.js}`],
      migrationsRun: true,
    }),
    UserModule,
    PerfilModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
