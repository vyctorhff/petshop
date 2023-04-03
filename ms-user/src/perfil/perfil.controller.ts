import { Controller, Get, Query } from '@nestjs/common';
import { PerfilService } from './perfil.service';
import { Perfil } from './domains/perfil.domain';
import { FindDTO } from './dtos/find.dto';
import { AutorizationService } from './autorization.service';

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
  isUserAdmin() {
    return this.autorizationService.isUserAdmin();
  }

  @Get('check/employee')
  isUserEmployee() {
    return this.autorizationService.isUserEmployee();
  }

  @Get('check/')
  isUserBasic() {
    return this.autorizationService.isUserBasic();
  }
}
