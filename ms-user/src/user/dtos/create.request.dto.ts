import { User } from '../entities/user.entity';

export const toUser = (dto: UserCreateRequestDTO): User => {
  return {
    id: '',
    name: dto.name,
    enrollment: dto.enrollment,
    perfils: [],
  };
};

export class UserCreateRequestDTO {
  name: string;

  enrollment: string;
}
