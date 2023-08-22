import { Test, TestingModule } from '@nestjs/testing';
import { getRepositoryToken } from '@nestjs/typeorm';

import { PerfilController } from '../perfil.controller';
import { PerfilService } from '../perfil.service';
import { AutorizationService } from '../autorization.service';
import { Perfil } from '../entities/perfil.entity';

describe('PerfilController', () => {
  let controller: PerfilController;
  let service: PerfilService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [PerfilController],
      providers: [
        PerfilService,
        AutorizationService,
        {
          provide: getRepositoryToken(Perfil),
          useValue: {},
        },
      ],
    }).compile();

    controller = module.get<PerfilController>(PerfilController);
    service = module.get<PerfilService>(PerfilService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
    expect(service).toBeDefined();
  });
});
