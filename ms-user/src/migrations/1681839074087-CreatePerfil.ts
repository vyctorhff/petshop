import { MigrationInterface, QueryRunner } from 'typeorm';
import { DataNames } from './dataNames';

const perfilTable = DataNames.PERFIL.toString();

export class CreatePerfil1681839074087 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    const query = `
            CREATE TABLE ${perfilTable}(
                id INT,
                name VARCHAR(30) NOT NULL,

                CONSTRAINT pk_perfil primary key(id)
            );
        `;

    await queryRunner.query(query);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DROP TABLE ${perfilTable};`);
  }
}
