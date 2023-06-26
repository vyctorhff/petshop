import { MigrationInterface, QueryRunner } from 'typeorm';
import { DataNames } from './dataNames';

const tableUser = DataNames.USER.toString();

export class InsertAdminName1686938889842 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    const sql = `UPDATE ${tableUser} SET name = 'admin' WHERE enrollment = '0';`;
    queryRunner.query(sql);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    queryRunner.query(
      `UPDATE ${tableUser} SET name = 'admin' WHERE enrollment = '';`,
    );
  }
}
