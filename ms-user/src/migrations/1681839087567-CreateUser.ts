import { MigrationInterface, QueryRunner } from 'typeorm';
import { DataNames } from './dataNames';

const userTable = DataNames.USER.toString();
const userPerfilTable = DataNames.USER_PERFIL.toString();

export class CreateUser1681839087567 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
        CREATE TABLE ${userTable}(
            id INT,
            CONSTRAINT pk_user PRIMARY KEY (id)
        );
    `);

  //   await queryRunner.query(`
  //     CREATE TABLE ${DataNames.USER_PERFIL.toString()}(
  //         id_user INT,
  //         id_perfil INT,

  //         CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES ${userTable} (id)",
  //         CONSTRAINT fk_perfil FOREIGN KEY (id_perfil) REFERENCES ${userPerfilTable} (id)",
  //     );
  // `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DROP TABLE ${userTable}`);
    await queryRunner.query(`DROP TABLE ${userPerfilTable}`);
  }
}
