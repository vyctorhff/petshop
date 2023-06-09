import { MigrationInterface, QueryRunner } from 'typeorm';

import { DataNames } from './dataNames';

const tablePerfil = DataNames.PERFIL.toString();

export class AddingPerfis1682431173697 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    const query = `
        INSERT INTO ${tablePerfil}
            (id, name)
        VALUES
            ('1', 'basic'),
            ('2', 'employee'),
            ('3', 'admin');
    `;
    await queryRunner.query(query);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DELETE * FROM ${tablePerfil};`);
  }
}
