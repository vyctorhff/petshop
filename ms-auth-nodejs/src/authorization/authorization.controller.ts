import { Controller, Post, Body } from '@nestjs/common';

import { AuthorizationService } from './authorization.service';
import { TokenRequestDTO } from './dtos/token.request.dto';
import { TokenResponseDTO } from './dtos/token.response.dto';
import { AuthenticationCreateRequestDTO } from './dtos/create.request.dto';
import { CreateAuthorizationService } from './create-authorization.service';
import { Authentication } from './entities/authorization.entity';

@Controller('authorization')
export class AuthorizationController {
  constructor(
    private readonly authService: AuthorizationService,
    private readonly createService: CreateAuthorizationService,
  ) {}

  @Post()
  async token(
    @Body() tokenRequest: TokenRequestDTO,
  ): Promise<TokenResponseDTO> {
    return await this.authService.getToken(tokenRequest);
  }

  @Post('create')
  async create(
    @Body() dto: AuthenticationCreateRequestDTO,
  ): Promise<Authentication> {
    return this.createService.create(dto);
  }
}
