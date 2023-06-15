import { Entity, JoinTable, ManyToMany, PrimaryGeneratedColumn } from 'typeorm';

import { Perfil } from 'src/perfil/entities/perfil.entity';
import { DataNames } from './../../migrations/dataNames'

@Entity({name: 'tb_user'})
export class User {

  @PrimaryGeneratedColumn()
  id: string;

  enrollment: string;

  @ManyToMany(() => Perfil, (perfil) => perfil.users)
  @JoinTable({
    name: DataNames.USER_PERFIL.toString(),
    joinColumn: {
      name: 'id_user',
      referencedColumnName: 'id'
    },
    inverseJoinColumn: {
      name: 'id_perfil',
      referencedColumnName: 'id',
    },
  })
  perfils: Perfil[];
}
