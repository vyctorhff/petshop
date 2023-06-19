import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';

@Entity()
export class Authentication {

  @PrimaryGeneratedColumn()
  id: string;

  @Column()
  key: string;

  @Column()
  password: string;

  constructor(key: string, password: string) {
    this.key = key;
    this.password = password;
  }
}