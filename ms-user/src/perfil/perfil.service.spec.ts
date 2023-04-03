import { Test, TestingModule } from '@nestjs/testing';
import { PerfilService } from './perfil.service';
import { PerfilRepository } from './perfil.repository';

describe('PerfilService', () => {
  let service: PerfilService;
  let repository: PerfilRepository;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [PerfilService, PerfilRepository],
    }).compile();

    service = module.get<PerfilService>(PerfilService);
    repository = module.get<PerfilRepository>(PerfilRepository);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
    expect(repository).toBeDefined();
  });
});
