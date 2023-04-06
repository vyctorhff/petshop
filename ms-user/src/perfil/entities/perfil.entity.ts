import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity({ name: 'tb_perfil' })
export class Perfil {
  @PrimaryGeneratedColumn()
  id: string;

  @Column()
  name: string;
}
