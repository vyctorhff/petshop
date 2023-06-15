import { Controller, Get, Body } from '@nestjs/common';

import { PerfilService } from './perfil.service';
import { Perfil } from './entities/perfil.entity';
import { createDto } from './dtos/find.dto';
import { AutorizationService } from './autorization.service';
import { UserAutorizationDto } from './dtos/user-autorization.dto';

@Controller('perfil')
export class PerfilController {
  constructor(
    private readonly service: PerfilService,
    private readonly autorizationService: AutorizationService,
  ) {}

  @Get('v1')
  async find(@Body() data: Record<string, string>): Promise<Perfil[]> {
    const dto = createDto(data);
    return await this.service.findAll(dto);
  }

  @Get('v1/check/admin')
  async isUserAdmin(@Body() user: UserAutorizationDto): Promise<boolean> {
    return await this.autorizationService.isUserAdmin(user);
  }

  @Get('v1/check/employee')
  async isUserEmployee(@Body() user: UserAutorizationDto): Promise<boolean> {
    return await this.autorizationService.isUserEmployee(user);
  }

  @Get('v1/check/basic')
  async isUserBasic(@Body() user: UserAutorizationDto): Promise<boolean> {
    return await this.autorizationService.isUserBasic(user);
  }
}
