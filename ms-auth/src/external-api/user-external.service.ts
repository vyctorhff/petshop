import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';
import { HttpService } from '@nestjs/axios';
import { firstValueFrom } from 'rxjs';

export class UserLoginDto {
  enrollment: string;

  name: string;
}

@Injectable()
export class UserExternalService {
  constructor(
    private configService: ConfigService,
    private httpService: HttpService,
  ) {}

  async getUserByEnrollmentAndPass(enrollment: string, pass: string): Promise<UserLoginDto> {
    const url = `${this.configService.get<string>('MS_USER')}/user`
    const payload = {
      enrollment,
      pass
    };

    const postObserver = this.httpService.post<UserLoginDto>(url, payload);
    const response = await firstValueFrom(postObserver.pipe());

    return response.data;
  }
}
