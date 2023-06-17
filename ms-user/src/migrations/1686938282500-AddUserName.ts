import { MigrationInterface, QueryRunner } from "typeorm"
import { DataNames } from "./dataNames"

const tableUser = DataNames.USER.toString();

export class AddUserName1686938282500 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        const sql = `
            ALTER TABLE ${tableUser} ADD COLUMN name varchar(20);
        `;

        queryRunner.query(sql);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        queryRunner.query(`ALTER TABLE ${tableUser} DROP COLUMN name;`);
    }

}
