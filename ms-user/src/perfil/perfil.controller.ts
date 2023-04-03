import { Controller, Get, Query } from '@nestjs/common';
import { PerfilService } from './perfil.service';
import { Perfil } from './domains/perfil.domain';
import { FindDTO } from './dtos/find.dto';

@Controller('perfil')
export class PerfilController {
  constructor(private readonly service: PerfilService) {}

  @Get()
  async find(@Query() findDto: FindDTO): Promise<Perfil[]> {
    return this.service.findAll();
  }

  @Get('check/admin')
  isUserAdmin() {
    return this.service.isUserAdmin();
  }

  @Get('check/employee')
  isUserEmployee() {
    return this.service.isUserEmployee();
  }

  @Get('check/')
  isUserBasic() {
    return this.service.isUserBasic();
  }
}
