import { MigrationInterface, QueryRunner } from "typeorm"
import { DataNames } from "./dataNames";

const tableUser = DataNames.USER.toString();

export class AddUserAdmin1686938064707 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        const sql = `
            INSERT INTO ${tableUser}
            (id, enrollment)
            VALUES
            ('0', 0);
        `;

        queryRunner.query(sql);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        queryRunner.query(`DELETE FROM ${tableUser};`);
    }

}
