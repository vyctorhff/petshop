import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { TokenRequestDTO } from './dtos/token.request.dto';
import { TokenResponseDTO } from './dtos/token.response.dto';

@Injectable()
export class AuthorizationService {

  constructor(
    private readonly jwtService: JwtService,
  ) {}

  async getToken(tokenRequest: TokenRequestDTO): Promise<TokenResponseDTO> {
    // TODO: call ms-user to find user by enrollment and password
    // TODO: if user does not exists, throw error 'invalid credentions'

    const payload = {
      perfils: [],
      userId: '',
      userName: '',
    };

    const token = await this.jwtService.signAsync(payload)
    const refresh = '';

    const result: TokenResponseDTO = {
      time: new Date(),
      token,
      refresh,
    };

    return result;
  }
}