import { Authentication } from '../entities/authorization.entity';

export const toEntity = (dto: AuthenticationCreateRequestDTO): Authentication => {
  return new Authentication(dto.key, dto.password);
}

export class AuthenticationCreateRequestDTO {
  key: string;

  password: string;
}