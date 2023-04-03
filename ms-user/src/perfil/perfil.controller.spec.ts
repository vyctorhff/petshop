import { Test, TestingModule } from '@nestjs/testing';
import { PerfilController } from './perfil.controller';
import { PerfilService } from './perfil.service';
import { PerfilRepository } from './perfil.repository';
import { AutorizationService } from './autorization.service';

describe('PerfilController', () => {
  let controller: PerfilController;
  let service: PerfilService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [PerfilController],
      providers: [PerfilRepository, PerfilService, AutorizationService],
    }).compile();

    controller = module.get<PerfilController>(PerfilController);
    service = module.get<PerfilService>(PerfilService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
    expect(service).toBeDefined();
  });
});
