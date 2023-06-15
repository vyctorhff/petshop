import { Test, TestingModule } from '@nestjs/testing';
import { PerfilService } from './perfil.service';
import { getRepositoryToken } from '@nestjs/typeorm';
import { Perfil } from './entities/perfil.entity';

describe('PerfilService', () => {
  let service: PerfilService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        PerfilService,
        {
          provide: getRepositoryToken(Perfil),
          useValue: {},
        },
      ],
    }).compile();

    service = module.get<PerfilService>(PerfilService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
