import { BadRequestException, Injectable, Logger } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";

import { Authentication } from "./entities/authorization.entity";
import { AuthenticationCreateRequestDTO, toEntity } from "./dtos/create.request.dto";
import { AuthorizationService } from "./authorization.service";

@Injectable()
export class CreateAuthorizationService {
  private logger: Logger = new Logger('CreateAuthorizationService');

  constructor(
    @InjectRepository(Authentication)
    private repository: Repository<Authentication>,
    private authenticationService: AuthorizationService,
  ) {}

  async create(dto: AuthenticationCreateRequestDTO): Promise<Authentication> {
    const authInDataBase = this.authenticationService.findByKey(dto.key);

    if (authInDataBase) {
      throw new BadRequestException('auth already exists');
    }

    this.logger.log(`Creating authentication for ${dto.key}`);

    const entity = toEntity(dto);
    return this.repository.save(entity);
  }
}
