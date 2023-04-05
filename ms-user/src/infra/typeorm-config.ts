import { ConfigService } from '@nestjs/config';
import { TypeOrmModuleOptions } from '@nestjs/typeorm';

const typeOrmFactory = (
  configService: ConfigService,
): TypeOrmModuleOptions => ({
  type: 'postgres',
  host: configService.get<string>('DATABASE_HOST'),
  port: configService.get<number>('DATABASE_PORT'),
  username: configService.get<string>('DATABASE_USER'),
  password: configService.get<string>('DATABASE_PASS'),
  database: configService.get<string>('DATABASE_NAME'),
  synchronize: configService.get<boolean>('DATABASE_SYNC'),
  entities: [__dirname + '/**/*.entity{.ts,.js}'],
});

export default typeOrmFactory;