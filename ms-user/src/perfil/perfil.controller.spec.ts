import { Test, TestingModule } from '@nestjs/testing';
import { PerfilController } from './perfil.controller';
import { PerfilService } from './perfil.service';

describe('PerfilController', () => {
  let controller: PerfilController;
  let service: PerfilService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [PerfilController],
      providers: [PerfilService],
    }).compile();

    controller = module.get<PerfilController>(PerfilController);
    service = module.get<PerfilService>(PerfilService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
    expect(service).toBeDefined();
  });

  describe('find', () => {
    it('should return all perfis',async () => {
      const list = await controller.find({});

      expect(list).not.toHaveLength(0);
    });
  });
});
