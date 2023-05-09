import { MigrationInterface, QueryRunner } from "typeorm"
import { DataNames } from "./dataNames"

const tableUser = DataNames.USER;

export class AddingEnrollementInUser1683571789001 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        queryRunner.query(`ALTER TABLE ${tableUser} ADD COLUMN enrollment varchar(10);`); 
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        queryRunner.query(`ALTER TABLE ${tableUser} DROP COLUMN enrollment;`);
    }

}
