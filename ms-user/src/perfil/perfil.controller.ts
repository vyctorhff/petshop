import { Controller, Get, Query } from '@nestjs/common';
import { PerfilService } from './perfil.service';
import { Perfil } from './domains/perfil.domain';
import { FindDTO } from './dtos/find.dto';

@Controller('perfil')
export class PerfilController {
  constructor(private readonly perfilService: PerfilService) {}

  @Get()
  find(@Query() findDto: FindDTO): Perfil[] {
    return [
      { name: 'admin' },
      { name: 'employee' },
      { name: 'user' },
    ];
  }
}
