import { ConfigService } from '@nestjs/config';
import { TypeOrmModuleOptions } from '@nestjs/typeorm';

import { DataSource, DataSourceOptions } from 'typeorm';

export const dataOptions: DataSourceOptions = {
  type: 'postgres',
  host: 'localhost',
  port: 5432,
  username: 'dev',
  password: '123',
  database: 'petshot-ms-user',
  migrations: ['C:/Users/victor.figueiredo/Documents/pessoal/projetos/petshop/ms-user/test/1686165753744-Novo.ts'],
  synchronize: false,
  entities: [__dirname + '/**/*.entity.ts'],
}

// const typeOrmFactory = (
//   configService: ConfigService,
// ): TypeOrmModuleOptions => ({
//   type: 'postgres',
//   host: configService.get<string>('DATABASE_HOST'),
//   port: configService.get<number>('DATABASE_PORT'),
//   username: configService.get<string>('DATABASE_USER'),
//   password: configService.get<string>('DATABASE_PASS'),
//   database: configService.get<string>('DATABASE_NAME'),
//   synchronize: false,
//   entities: [__dirname + '/**/*.entity.ts'],
// });

// export default typeOrmFactory;

const dataSource = new DataSource(dataOptions);
export default dataSource;
