import { MigrationInterface, QueryRunner } from "typeorm"
import { DataNames } from "./dataNames";

const tableAuthentication = DataNames.AUTHENTICATION.toString();

export class CreateAuthentication1687028862966 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        const sql = `
            CREATE TABLE ${tableAuthentication}(
                id varchar(50),
                key varchar(10),
                password varchar(50)
            );
        `;
        queryRunner.query(sql);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        queryRunner.query(`DROP TABLE ${tableAuthentication};`);
    }

}
