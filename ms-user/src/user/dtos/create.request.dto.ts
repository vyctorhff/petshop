import { User } from "../entities/user.entity";

export const toUser = (dto: UserCreateRequestDTO): User => {
  // TODO:  fazer
  return new User();
}

export class UserCreateRequestDTO {
  name: string;

  enrollment: string;
}