import { Perfil } from 'src/perfil/entities/perfil.entity';
import { JoinColumn, ManyToMany, PrimaryGeneratedColumn } from 'typeorm';

export class User {

  @PrimaryGeneratedColumn()
  id: string;

  enrollment: string;

  @ManyToMany(() => Perfil, (perfil) => perfil.users)
  @JoinColumn()
  perfils: Perfil[];
}
