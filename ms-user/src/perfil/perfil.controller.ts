import { Controller, Get, Query } from '@nestjs/common';

import { PerfilService } from './perfil.service';
import { Perfil } from './entities/perfil.entity';
import { FindDTO } from './dtos/find.dto';
import { AutorizationService } from './autorization.service';
import { UserAutorizationDto } from './dtos/user-autorization.dto';

@Controller('perfil')
export class PerfilController {
  constructor(
    private readonly service: PerfilService,
    private readonly autorizationService: AutorizationService,
  ) {}

  @Get()
  async find(@Query() findDto: FindDTO): Promise<Perfil[]> {
    return this.service.findAll();
  }

  @Get('check/admin')
  isUserAdmin(@Query() user: UserAutorizationDto) {
    return this.autorizationService.isUserAdmin(user);
  }

  @Get('check/employee')
  isUserEmployee(@Query() user: UserAutorizationDto) {
    return this.autorizationService.isUserEmployee(user);
  }

  @Get('check/')
  isUserBasic(@Query() user: UserAutorizationDto) {
    return this.autorizationService.isUserBasic(user);
  }
}
