import { User } from 'src/user/entities/user.entity';
import { Column, Entity, ManyToMany, PrimaryGeneratedColumn } from 'typeorm';

@Entity({ name: 'tb_perfil' })
export class Perfil {
  @PrimaryGeneratedColumn()
  id: string;

  @Column()
  name: string;

  @ManyToMany(() => User, (user) => user.perfils)
  users: User[];
}
